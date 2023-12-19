package LetsGetTakeOut;

public interface IntUserInputRetriver <T> {
    public T produceOutputOnIntUserInput(int selection) throws IllegalArgumentException;
}
