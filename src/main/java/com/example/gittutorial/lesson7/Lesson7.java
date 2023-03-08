package com.example.gittutorial.lesson7;

public class Lesson7 {
    
    /*
        git pull          = git fetch + git merge against tracking upstream branch
    
        git pull --rebase = git fetch + git rebase against tracking upstream branch
     */
    
    /*
    
        Suppose you have two commits in local branch:
    
                  D---E master
                 /
            A---B---C---F origin/master
            
        After "git pull", will be:
        
                  D--------E  
                 /          \
            A---B---C---F----G   master, origin/master
            
            
            
        After "git pull --rebase", there will be no merge point G. Note that D and E become different commits:
        
        A---B---C---F---D'---E'   master, origin/master

     */
    
    /*
        https://www.derekgourlay.com/blog/git-when-to-merge-vs-when-to-rebase/
    
        Rule of thumb:
            > When pulling changes from origin/develop onto your local develop use rebase.
            > When finishing a feature branch merge the changes back to develop.
            
            Use git pull --rebase when pulling changes from origin
            
            Difference between git pull & git pull --rebase:
            
                Situation #1: You haven’t made any changes to your local develop branch and you want to pull changes 
                              from origin/develop.
                
                    In this case, git pull and git pull --rebase will produce the same results. No problems.
                
                Situation #2: You’ve got one or two small changes of your own on your local develop branch that have 
                              not yet been pushed. You want to pull any changes you are missing from origin/develop 
                              to your local develop before you can push.
                
                                             origin/develop
                                               |
                                 +−−−− (E)−−−−(F)
                                /                 
                        (A) −− (B)−−−−−−− (C) −− (D)  
                                                  |          
                                                develop
                                                
                A regular git pull will often result in the following:
                
                                         origin/develop
                                               |        
                                 +−−−− (E)−−−−(F)−−−−−−−−−−−−−−−−
                                /                                \
                        (A) −− (B) −−−−−−−−(C) −− (D)−−−−(G − merge commit)  
                                                                  |          
                                                                develop 
                                                                
                Unfortunately you no longer have a linear commit history. And after pushing your git history looks like:
                
                             +−−−− (E)−−−−(F)−−−−−−−−−−−−−−−−
                            /                                \
                    (A) −− (B) −−−−−−−−(C) −− (D)−−−−(G − merge commit)  
                                                              |          
                                                            develop 
                                                              |
                                                       origin/develop
                                                       
                Instead use git pull –rebase:
                
                    (A) −− (B)−−−−−−− (E) −− (F) −−−−−−− (C') −− (D') 
                                              |                   |
                                        origin/develop         develop
                                        
                During the rebase your local commits C & D are played in order on top of the changes you pulled 
                from origin/develop. These commits are replaced with C’ & D’ as you solve local conflicts one commit 
                at a time when they are replayed. Now pushing to origin/develop results in a fast-forward and a nice 
                clean git history:
                
                    (A) −− (B)−−−−−−− (E) −− (F) −−−−−−− (C') −− (D') 
                                                                  |
                                                               develop  
                                                                  |
                                                            origin/develop
                                                            
 
                Use git merge when finishing off a feature branch.
                
                Example of merging a feature branch back into develop before pushing:
                
                                     origin/develop                       develop
                                           |                                 |        
                             +−−−− (C)−−−−(D)−−−−−−−−−−−(H − Merging completed Feature for TMS−123)−−−−−
                            /                           /      
                    (A) −− (B) −−−−−−−−(E) −− (F)−−−−(G)  
                                                      |          
                                             feature/TMS−123/myCoolFeature
                                         
                After pushing to origin:
                
                                                                       origin/develop 
                                                                              |
                                                                           develop
                                                                             |        
                             +−−−− (C)−−−−(D)−−−−−−−−−−−(H − Merging completed Feature for TMS−123)−−−−−
                            /                           /      
                    (A) −− (B) −−−−−−−−(E) −− (F)−−−−(G)  
                                                      |          
                                             feature/TMS−123/myCoolFeature
                         
                         
       -----------------------------------------------------------------------------------------------------------------                  
       Hold on, git pull --rebase isn’t all gravy!
       
        While it is possible to set your system to default to git pull --rebase over using the regular git pull you 
        will occasionally find you run into problems such as the following scenario:
        
        You slave away working on a local feature branch and finish it off by merging it back into develop 
        (using the --no-ff flag of course) resulting in the same history as the previous example:
                
                                                                   origin/develop 
                                                                         |
                                                                       develop
                                                                         |        
                         +−−−− (C)−−−−(D)−−−−−−−−−−−(H − Merging completed Feature for TMS−123)−−−−−
                        /                           /      
                (A) −− (B) −−−−−−−−(E) −− (F)−−−−(G)  
                                                  |          
                                         feature/TMS−123/myCoolFeature
                                 
        However after running git fetch you notice that origin/develop is 2 commits of head of develop:
        
                                                                       develop                        origin/develop
                                                                         |                                  |
                         +−−−− (C)−−−−(D)−−−−−−−−−−−(H − Merging completed Feature for TMS−123)−−−−−(I)−−−−(J)
                        /                           /      
                (A) −− (B) −−−−−−−−(E)−−−−(F)−−−−(G)  
                                                  |          
                                         feature/TMS−123/myCoolFeature
                                         
                                         
        You run git pull –rebase as told and all of a sudden something strange has happened:
        
                (A) −− (B) −−−−−−(C)−−−(D)−−−−(I)−−−−(J)−−−−(E')−−−−−(F')−−−−−(G')−−−−  
                        \                             |                        |         
                         \                      origin/develop             develop
                          \
                            −−−−−−−−(E)−−−−(F)−−−−(G) 
                                                   |          
                                          feature/TMS−123/myCoolFeature
                                          
                                          
        Your merge commit has disappeared!
        
        What we really wanted was:
        
                                                origin/develop                 develop  
                                                     |                           |          
                     +−−−− (C)−−−−(D)−−−−−−−(I)−−−−−(J)−−−−−−−−(H' − Merging completed Feature for TMS−123)
                    /                                                        /      
            (A) −− (B) −−−−−−−−(E)−−−−(F)−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−(G)  
                                                                            |          
                                                             feature/TMS−123/myCoolFeature
                                                             
        The problem is…
        
            Rebasing Deletes Merge Commits!
        
       ----------------------------------------------------------------------------------------------------------------- 
       Welcome the –preserve-merges flag to center stage:
        From the git-rebase manpage:
        
            −p, −−preserve−merges
                       Instead of ignoring merges, try to recreate them.
                       This uses the −−interactive machinery internally, 
                       but combining it with the −−interactive option explicitly 
                       is generally not a good idea unless you know what you are 
                       doing (see BUGS below).
                       
        So, instead of using git pull –rebase, use:
        
        git fetch origin and git rebase -p origin/develop
                 
       -----------------------------------------------------------------------------------------------------------------
        Downsides to git rebase -p:

            Git pull is dead!
            
            Unfortunately the -p flag cannot be used in conjunction with git pull ( git pull –rebase -p doesn’t work!) 
            and as a result you have to explicitly fetch & rebase changes from origin.
            
            ORIG_HEAD is no longer preserved      
                       
       -----------------------------------------------------------------------------------------------------------------
       
       Conclusion
        To avoid messy merge commits and help keep a relatively clean git commit history use the following workflow 
        when fetching upstream changes:
        
        git fetch origin
        git rebase −p origin/develop
        
        For further reading about the inner workings of Git, I found the Git Internals section of the Pro Git book very helpful!
                  
     */
}
