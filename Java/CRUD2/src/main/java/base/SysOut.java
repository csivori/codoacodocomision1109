package base;

public class SysOut {
// ATRIBUTOS PUBLICOS
    public static int showDebugMsgs = 0;
// ATRIBUTOS PRIVADOS
// METODOS PUBLICOS
    public static void lnprint(String msg) {
        print("\n" + msg);
    }

    public static void lnprintln(String msg) {
        println("\n" + msg);
    }

    public static void print(String msg) {
        System.out.print(msg);
    }

    public static void println(String msg) {
        System.out.println(msg);
    }

    public static void dbglnprintln(String msg, int nivel) {
        if (nivel < showDebugMsgs) {
            dbgprt(msg, true);
        }
    }

    public static void dbgprintln(String msg, int nivel) {
        if (nivel < showDebugMsgs) {
            dbgprt(msg, false);
        }
    }

    public static void dbgprt(String msg, boolean preLn) {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        final int profundidad = 3;
        println(((preLn) ? "\n" : "") + "*** Cls(" + ste[profundidad].getClassName() + ")." + ste[profundidad].getMethodName() + "(): " + msg + " ***");
    }

    public static String getMetodo(final int depth) {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[ste.length - 1 - depth].getMethodName();
    }

    public static String getClase(final int depth) {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[ste.length - 1 - depth].getClassName();
    }
}