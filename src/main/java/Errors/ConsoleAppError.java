package Errors;

public class ConsoleAppError extends Throwable {
    public ConsoleAppError(Throwable e) {
        this.setStackTrace(e.getStackTrace());
    }
}
