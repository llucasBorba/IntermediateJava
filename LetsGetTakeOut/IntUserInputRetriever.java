package LetsGetTakeOut;

public interface IntUserInputRetriever<T> {
    public T produceOutputOnIntUserInput(int selection) throws IllegalArgumentException;
}
