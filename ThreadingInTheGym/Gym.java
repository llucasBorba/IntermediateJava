package ThreadingInTheGym;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gym {

    private final int totalGymMembers;
    private Map<MachineType, Integer> availableMachines;

    public Gym(int totalGymMembers, Map<MachineType, Integer> availableMachines) {
        this.totalGymMembers = totalGymMembers;
        this.availableMachines = availableMachines;
    }

    public void openForTheDay(){
        List<Thread> gymMembersRoutines;
        gymMembersRoutines = IntStream.rangeClosed(1, this.totalGymMembers).mapToObj(
                (id) ->{
                    Member member = new Member(id);
                    return new Thread(() -> {
                        try{
                         member.performRoutine();
                        }catch (Exception e){
                            System.out.println(e);
                        }

                    });
                }).collect(Collectors.toList());

        gymMembersRoutines.forEach(Thread::start);
    }

    private Thread createSupervisor(List<Thread> threads){
        Thread supervisor = new Thread(() -> {
            while(true){
                List<String> runningThreads = threads.stream().filter(Thread::isAlive).map(Thread::getName).toList();
                System.out.println(Thread.currentThread().getName() + "-" + runningThreads.size() + "people still working out" + runningThreads + "\n");
                if(runningThreads.isEmpty()){
                    break;
                }
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " - All members are finished exercising!");
        });
        supervisor.setName("Gym Staf");
        return supervisor;
    }
}
