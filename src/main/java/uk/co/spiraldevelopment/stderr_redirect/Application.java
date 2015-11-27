package uk.co.spiraldevelopment.stderr_redirect;

import java.io.*;

/**
 * Sample application that will show the behaviour of redirecting stderr within the app.
 * Based on http://stackoverflow.com/a/4183433/2553497
 */
public class Application {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setErr(new PrintStream(baos));

        System.err.println("Error string 1");
        System.out.print("Err: " + baos.toString());

        System.out.println("Size pre reset: " + baos.size());
        baos.reset();
        System.out.println("Size post reset: " + baos.size());

        System.err.println("Error string 2");
        System.out.print("Err: " + baos.toString());
        baos.reset();

        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err)));
        System.err.println("Error String 3");

        System.out.println("Err: " + baos.toString());
    }
}
