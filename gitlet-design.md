# Gitlet Design Document

**Name**: Maxim Kirby

## Classes and Data Structures

### Repository Class
#### Fields:
###### Branch References:
1. Current branch name.
2. Map from branch name to branch ID.
3. HEAD commit ID.

###### Commit Search:
4. Map from commit ID to commit Obj.

###### Blob Search:
5. Map from blob ID to blob Obj.

###### Stage:
6. Map from blob name to blob ID.
7. List of blob ID.

#### Methods:
1. initialize: create directory to store commits and blobs.
2. add: adds a file to staging area.
3. rm: removes a file from staging area.
4. commit: creates a new commit by updating the old commit with changes made on the stage.
5. log: prints out all commits starting from the HEAD of the current branch.
6. globalLog: prints out all commits.
7. find: prints out all commits with specific message.
8. status: prints info about the current branch and staging details.
9. checkout: checkout files from a commit ID (can be concatenated) or parent commit (if left empty)
10. checkoutBranch: checks out all files from a branch name.
11. reset: checks out all files from a commit ID (can be concatenated).
12. branch: creates new branch.
13. rmBranch: removes existing branch.
14. merge: merges a specified branch into the current branch and will specify any merge conflicts (uses BFS to find common ancestor).

### Commit Class
#### Fields:
1. commit ID.
2. commit message.
3. timestamp for commit creation.
4. array of parent commit ID(s).
5. Map from file names to blob ID(s).
#### Methods:
1. getId: returns commit ID of commit  Obj.
2. getMessage: returns commit message of commit Obj.
3. getTimestamp: returns timestamp of commit Obj.
4. getParents: returns array of parent(s).
5. setOtherParent: sets a 2nd parent to specified commit ID.
6. getFiles: returns mapping of files to blob IDs.
7. toString: formatted printing of commit Obj.

### Blob Class
#### Fields:
1. blob ID.
2. blob name (file name).
3. byte array of file content.
#### Methods:
1. getId: returns blob ID of blob Obj.
2. getName: returns blob name of blob Obj.
3. getContent: returns content as byte array. 