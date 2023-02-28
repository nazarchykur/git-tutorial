package com.example.gittutorial.lesson4;

public class Lesson4 {
    /*
    git fetch 
    git merge
    
        user@user-Nitro-AN515-54:~/IdeaProjects/study/git-tutorial$ glg
            * 778589b (origin/master) Create newFile
            * 9eb27b1 (HEAD -> master) added conclusion about how to use reset command
            *   f42e799 Merge pull request #1 from nazarchykur/lesson3
        
        
        
        some new changes are in repo
        git fetch - get changes to local storage but not merge them
        
            user@user-Nitro-AN515-54:~/IdeaProjects/study/git-tutorial$ git fetch
                remote: Enumerating objects: 16, done.
                remote: Counting objects: 100% (16/16), done.
                remote: Compressing objects: 100% (5/5), done.
                Unpacking objects: 100% (9/9), 983 bytes | 163.00 KiB/s, done.
                remote: Total 9 (delta 2), reused 0 (delta 0), pack-reused 0
                From mygithub:nazarchykur/git-tutorial
                   9eb27b1..778589b  master     -> origin/master
                user@user-Nitro-AN515-54:~/IdeaProjects/study/git-tutorial$ glg
                * 778589b (origin/master) Create newFile                                         <= new changes 
                * 9eb27b1 (HEAD -> master) added conclusion about how to use reset command       <= HEAD still at previous commit
                *   f42e799 Merge pull request #1 from nazarchykur/lesson3


        merge fetched changes to local repo
        
            user@user-Nitro-AN515-54:~/IdeaProjects/study/git-tutorial$ git merge origin/master
                Updating 9eb27b1..778589b
                Fast-forward
                 src/main/java/com/example/gittutorial/newFile | 1 +
                 1 file changed, 1 insertion(+)
                 create mode 100644 src/main/java/com/example/gittutorial/newFile
                 
                 
                 
            user@user-Nitro-AN515-54:~/IdeaProjects/study/git-tutorial$ glg
                * 778589b (HEAD -> master, origin/master) Create newFile                  <= HEAD now at this commit
                * 9eb27b1 added conclusion about how to use reset command
                *   f42e799 Merge pull request #1 from nazarchykur/lesson3


     */
}
