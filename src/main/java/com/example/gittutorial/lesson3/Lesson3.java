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
    
    /*
    
    також можна використовувати замість commit ID (hash) переміщення за допомогою HEAD
    
    => якщо ми виконали зміни і ці зміни ще не додавали до Stage area (не виконали git add .) (git status => файли червоні), то 
        git checkout -- .          : видалить всі ці зміни з цієї Unstaged area     \
        git checkout -- <filename> : видалить конкретний файл з Unstaged area       /  git status тепер нічого не покаже
    
    
    => якщо ми добавили якісь зміни і вже додали їх до Stage area (виконали git add .): 
    
        git reset .        : зміни які були зроблені і додані до Stage area (файли зелені) тепер будуть у Unstaged area (файли червоні)  
   
    => якщо потрібно повернутися до змін з уже виконаними комітами:
          
        git reset --mixed [<commit ID> | <HEAD>...] : (--mixed = default) поверне зміни до цього коміту, а зміни, які були
                                                    у комітах вище додасть до Unstaged area (git status => файли червоні)    
                                                             
        git reset --soft [<commit ID> | <HEAD>...] : поверне зміни до цього коміту, а зміни, які були у комітах вище 
                                                     додасть до Stage area (git status => файли зелені)
                                                     
        git reset --hard [<commit ID> | <HEAD>...] : поверне зміни до цього коміту, а зміни, які були у комітах вище 
                                                     будуть видалені і git status уже нічого не покаже
        
        git reset --hard HEAD       (going back to HEAD)          
        git reset --hard HEAD^      (going back to the commit before HEAD)   
        git reset --hard HEAD~1     (equivalent to "^")       
        git reset --hard HEAD~2     (going back two commits before HEAD)
            
     */
}
