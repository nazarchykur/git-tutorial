package com.example.gittutorial.lesson6;

public class Lesson6 {
    /*
    
        git merge        
                    	  A---B---C topic
                         /
                        D---E---F---G master
            
            Then "git merge topic" will replay the changes made on the topic branch since it diverged from master (i.e., E) 
            until its current commit (C) on top of master, and record the result in a new commit along with the names of 
            the two parent commits and a log message from the user describing the changes.
                     
                      A---B---C topic
                     /         \
                    D---E---F---G---H master
                    
        git rebase
        
            Rebasing is the process of moving or combining a sequence of commits to a new base commit. 
            Rebasing is most useful and easily visualized in the context of a feature branching workflow.
            
                          A---B---C topic
                         /
                    D---E---F---G master
            
            git rebase master
            git rebase master topic   
            
                                   A'--B'--C' topic
                                 /
                    D---E---F---G master
            
            
            In case of conflict, git rebase will stop at the first problematic commit and leave conflict markers in 
            the tree. You can use git diff to locate the markers (<<<<<<) and make edits to resolve the conflict. 
            For each file you edit, you need to tell Git that the conflict has been resolved, typically this would be 
            done with

                    git add <filename>
            
            After resolving the conflict manually and updating the index with the desired resolution, you can continue 
            the rebasing process with

                    git rebase --continue
                    
            Alternatively, you can undo the git rebase with
            
                    git rebase --abort
        
            
            
            
            <upstream>
                Upstream branch to compare against. May be any valid commit, not just an existing branch name. 
                Defaults to the configured upstream for the current branch.
            
            <branch>
                Working branch; defaults to HEAD.
            
            --continue
                Restart the rebasing process after having resolved a merge conflict.
            
            --abort
                Abort the rebase operation and reset HEAD to the original branch. If <branch> was provided when the rebase 
                operation was started, then HEAD will be reset to <branch>. Otherwise HEAD will be reset to where it was 
                when the rebase operation was started.
            
            --quit
                Abort the rebase operation but HEAD is not reset back to the original branch. The index and working tree 
                are also left unchanged as a result. If a temporary stash entry was created using --autostash, it will be 
                saved to the stash list.

     */
    
    /*
        What git merge do:
            > Wouldn't change the commit timestamp
            > Wouldn't change the commit hash
            > Will create a new commit automatically
            > When there are many people are using the git merge in a project, it will cause commits across each other 
                in history, in the end it will show the commits like a Circuit board.
     */   
//                        |
//                        +
//                        | \
//                        |  \
//                        +   +
//                        + \/
//                        |\/\
//                        |/+ |
//                        + | +
//                        | + /
//                        |/ /  
//                        + / 
//                        +
//                        | 
    
     /*   
            How to do git merge:
                Step 1: git checkout feature . For example, git checkout feature/new_awesome_feature1.
                Step 2: git merge master , might need to resolve some conflicts while doing this step.



        What git rebase do:
            > Change the commit timestamp
            > Change the commit hash
            > Not introduce any new commit automatically
            > Generate nice and organised git history, like the one in the following:
      */
//                        +
//                        |\    
//                        | +
//                        |/
//                        +
//                        | 
//                        +
//                        |\
//                        | +
//                        |/
//                        +
//                        | \ 
//                        |  +
//                        |  + 
//                        | / 
//                        +
//                        | 
    
    
     /*
            
            How to do git rebase:
                Step 1: git checkout feature
                Step 2: git rebase master , might need to resolve some conflicts while doing this step. Here we might 
                        rebase the code multiple times. So it is a good idea to squash all the commits into one.


     */
}
