package gitlet;

import java.io.File;
import java.io.Serializable;
import static gitlet.Utils.*;

/** Represents a gitlet Blob object. **
 *
 *  A blob is an object used to store a file's name and contents. Blobs
 *  are given unique identifiers using a SHA1 hash based on the name and
 *  contents so that two files with the same name can be distinguished.
 *  Blobs are used as a means to save different versions of a file in
 *  gitlet so that older versions of a file can be retrieved at a later
 *  date.
 *
 *  @author Maxim Kirby
 */
public class Blob implements Serializable {
    /***************************************************************************************************
     INSTANCE VARIABLES */

    /** Unique identifier for this Blob. */
    private String id;

    /** Given name for Blob. */
    private String name;

    /** Given file contents for Blob. */
    private byte[] content;

    /***************************************************************************************************
     MAIN METHODS */

    /** Constructor. */
    public Blob(File f, String n) {
        name = n;
        content = readContents(f);
        id = sha1(name, content);
    }

        /** Returns String of Blob ID. */
    public String getId() {
        return id;
    }

    /** Returns String of Blob name. */
    public String getName() {
        return name;
    }

    /** Returns byte array of Blob contents. */
    public byte[] getContent() {
        return content;
    }
}
