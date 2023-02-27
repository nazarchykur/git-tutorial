package com.example.gittutorial.lesson3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Lesson3 {

    private String field1;
    
    
    
    /*
                
        git reset     
            git reset [<mode>] [<commit>]  : This form resets the current branch head to <commit> and possibly updates the index  
            
            --soft
                Does not touch the index file or the working tree at all (but resets the head to <commit>, just like all modes do). 
                This leaves all your changed files "Changes to be committed"
                
            --mixed   (This is the default action )
                Resets the index but not the working tree (i.e., the changed files are preserved but not marked for commit) 
                and reports what has not been updated.
                
            --hard
                Resets the index and working tree. Any changes to tracked files in the working tree since <commit> are 
                discarded. Any untracked files or directories in the way of writing any tracked files are simply deleted.
                
                
                
            git reset -- .  - remove from staged area

     */
}
