import runtime.JavaLoXRuntime;

import java.io.IOException;


public class JavaLoX {
    public static boolean hadError = false;

    public static void main(String[] args) throws IOException{
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        } else if (args.length == 1) {
            JavaLoXRuntime.runJLoXFile(args[0]);
        } else {
            JavaLoXRuntime.runJLoXPrompt();
        }
    }
}

