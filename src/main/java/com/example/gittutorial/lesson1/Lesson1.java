package com.example.gittutorial.lesson1;

public class Lesson1 {
    
    /*
    Git Commands
    
        git config
            Usage: git config –global user.name “[name]”
            Usage: git config –global user.email “[email address]”
        
            This command sets the author name and email address respectively to be used with your commits.
        
        git init
            Usage: git init [repository name]
            
            This command is used to start a new repository.
            
         git clone
            Usage: git clone [url]
            
            This command is used to obtain a repository from an existing URL.   
        
        git add
            git add [file]      : This command adds a file to the staging area.
            git add <directory> : Stage all changes in <directory> for the next commit.
            git add -A          : stages all files, including new, modified, and deleted files, including files in the 
                                  current directory and in higher directories that still belong to the same git repository
            git add .           : Stage all files (that are not listed in the .gitignore) in the entire repository
            git add -p          : Interactively stage hunks of changes
            git add -u          : stages modified and deleted files only, NOT new files
            
            
       git status     
            git status      : Always a good idea, this command shows you what branch you're on, what files are in the working or 
                                staging directory, and any other important information.
            git status -s   :  [-s / --short] Give output in short format
            git status -v   : Shows more "verbose" detail including the textual changes of any uncommitted files


        git checkout
            command can switch the currently active branch - but it can also be used to restore files. 
            
            git checkout <branch-name>       : The name of a local branch that you want to switch to. By specifying the name of 
                                               a local branch, you will switch to this branch and make it the current "HEAD" branch.

            git checkout -b <branch-name>    : Creates a new local branch and directly switches to it.   
                                               = shortcut = git branch <new-branch-name> + git checkout <new-branch-name>.
            
            git checkout <specific-commit-id> : switches to this commit                          
            git checkout                      : restore untracked changes
            git checkout -- <file     >       : скасувати існуючі зміни
        
        git restore    
            The "restore" command helps to unstage or even discard uncommitted local changes.

            On the one hand, the command can be used to undo the effects of git add and unstage changes you have 
            previously added to the Staging Area.
            On the other hand, the restore command can also be used to discard local changes in a file, thereby restoring 
            its last committed state.

            git restore <file>          : The name of a file (or multiple files) you want to restore.
            git restore --staged <file> : Removes the file from the Staging Area, but leaves its actual modifications untouched.
        
        git commit
            git commit -m "descriptive message": Records file snapshots permanently in version history.
            
            Якщо ви хочете переробити коміт — внесіть необхідні зміни, додайте їх до індексу та зробіть коміт ще раз, вказавши параметр --amend
            
            git commit -m 'Initial commit'
            git add forgotten_file
            git commit --amend
            
            git commit -a -m "new message if we want to change the last one"
            
            
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
    
                    
        
        git push    
            переносить всі зміни, внесені користувачем, у віддалений репозиторій (наприклад, такий як GitHub)
            
            Щоб надіслати дані до віддаленого репозиторію, потрібно переконатися, що всі зміни зафіксовані в локальному 
            репозиторії. Після того, як ви внесете зміни локально, ви зможете поділитись ними за допомогою git push. 
            Але перш ніж відправляти будь-які зміни у віддалену гілку, рекомендується запустити команду git pull. 
            Це оновить локальну гілку.
            
            git push: Uploads all local branch commits to the remote.
            git push --force origin main /
            git push -f : force the commit 
            
            
        git pull
            Команда git pullвідповідає за скачування даних із сервера. Процес дуже схожий на клонування репозиторію, 
            але тут завантажуються не всі комміти, а лише нові. 

            По суті,git pull- це поєднання команд git fetch(завантажує комміти, посилання, файли з віддаленого 
            репозиторію в локальний) та git merge(Об'єднує кілька коммітів в один загальний).
     
        
        git fetch
            Команда git fetch з'єднана з віддаленим репозиторієм, бере всі зміни та зберігає їх локально. При клонуванні 
            репозиторію, команда clone автоматично додає віддалений репозиторій під назвою origin. Отже,git fetch origin 
            виймає матеріал, надісланий на сервер після клонування.
        
        git merge
            Команда git merge пов'язує низку комітів в одне ціле.

        
        git cherry-pick
            Команда git cherry-pick бере зміни, що вносяться одним коммітом, і намагається повторно застосувати їх у 
            вигляді нового комміта в поточній гілці. Ця можливість корисна в ситуації, коли потрібно забрати парочку 
            коммітів з іншої гілки, а не зливати гілку цілком з усіма змінами, що внесені до неї.


        git rebase
            git rebase Це «автоматизований» cherry-pick. Він виконує ту ж роботу, але для ланцюжка коммітів, тим самим 
            переносячи гілку на нове місце.

     */
    
    /*
        # ----------------------
        # Git Aliases
        # ----------------------
                alias ga='git add'
                alias gb='git branch'
                alias gc='git commit'
                alias gcm='git commit --message'
                alias gco='git checkout'
                alias gcob='git checkout -b'
                alias gd='git diff'
                alias glgo='git log --oneline'
                alias glg='git log --graph --oneline --decorate --all'
                alias gld='git log --pretty=format:"%h %ad %s" --date=short --all'
                alias glgt='git log --graph --pretty=format:"%C(yellow)%h%x09%Creset%C(cyan)%C(bold)%ad%Creset  %C(green)%Creset %s" --date=short'
                alias gpl='git pull'
                alias gps='git push'
                alias gplo='git pull origin'
                alias gpso='git push origin'
                alias gst='git status'
     */
}
