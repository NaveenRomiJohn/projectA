 this.title = title;  // this.title is global variable ,and title is a local variable
 title = filmtitle;  // This is similar to this.title=filmtitle , but using this . prefix is not compulsory
 director = filmdirector; // This is similar to this.director= filmdirector  but using this . prefix is not compulsory
    // as there are no local variables by name title , or director so here they will implicitly referred to global variable
        // note : if title and director are not globaly then it will be undeclared variable cannot be resolved as variable.
        // if the parameter names are similar to global variables
    //  then there is an ambiguity between the local variables(parameter) and global variable.
    // hence this. prefix is used for referring the global variable
    // title = title will be referring the local variable on both sides of the = operator (x=x) self assigning.