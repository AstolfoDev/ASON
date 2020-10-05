package JSONReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

class JSONReader {

    OpenFile op;

    JSONReader(URL url) throws IOException {
        URLPARSER(url);
    }

    JSONReader(File file) throws IOException {
        FilePARSER(file);
    }

    private void FilePARSER(File file) throws IOException {
        op = new OpenFile();
        op.GetFileContents(file);
    }

    private void URLPARSER(URL url) throws IOException {
        op = new OpenFile();
        op.GetURLContents(url);
    }
}
