import java.io.*;

public class ManageResource {

    public static int  BUFFER_SIZE = 200;
    // try-with-resources on multiple resources - short and sweet
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }}
    // try-with-resources with a catch clause
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;}}

   /* Always use try-with-resources in preference to tryfinally when working with resources that must be closed. The resulting code
    is shorter and clearer, and the exceptions that it generates are more useful*/
}
