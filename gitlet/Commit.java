package gitlet;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import static gitlet.Utils.*;

/** Represents a gitlet commit object. **
 *
 *  A commit is an object used to track a snapshot of a directory. Commits
 *  store information about the files in the directory at the time of the
 *  snapshot, track which Commit came before it and is known as a parent.
 *  Each commit also contains metadata about the time the commit was created
 *  and a user specified message to remind the user what might be inside this
 *  commit. Each commit als has a unique identifier based on a SHA1 hash.
 *
 *  @author Maxim Kirby
 */

public class Commit implements Serializable {
    /***************************************************************************************************
    INSTANCE VARIABLES */

    /** Unique identifier for this Commit. */
    private String id;

    /** Metadata for Commit. */
    private String message;
    private String timestamp;

    /** IDs for each parent Commits. */
    private String[] parents;

    /** Mapping of filenames to Blob IDs for files in the Commit. */
    private TreeMap<String, String> files;

    /***************************************************************************************************
     MAIN METHODS */

    /** Constructor. */
    public Commit(String m, String p, TreeMap<String, String> f) {
        message = m;
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy Z");
        timestamp = sdf.format(currentDate);
        parents = new String[2];
        parents[0] = p;
        files = f;
        id = sha1(message+parents[0]+timestamp+files);
    }

    /** Returns String of Commit ID. */
    public String getId() {
        return id;
    }

    /** Returns String of Commit message. */
    public String getMessage() {
        return message;
    }

    /** Returns String of Commit timestamp. */
    public String getTimestamp() {
        return timestamp;
    }

    /** Returns String array of Commits parent IDs. */
    public String[] getParents() {
        return parents;
    }

    /** Sets secondary parent to specified Commit ID. */
    public void setOtherParent(String commitID) {
        parents[1] = commitID;
    }

    /** Returns TreeMap of filenames to Blob IDs for Commit. */
    public TreeMap<String, String> getFiles() {
        return files;
    }

    /** Formats printing of Commit. */
    @Override
    public String toString() {
        String result = "===\n" + "commit " + id;
        if (parents[1] != null) {
            result += "\nMerge: "+ parents[0].substring(0, 7) + " " + parents[1].substring(0, 7);
        }
        result += "\nDate: " + timestamp + "\n" + message+"\n";
        return result;
    }
}
