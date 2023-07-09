.source testex.j


.class public testex
.super java/lang/Object

    .method public static _test(II)java/util/ArrayList;
        .limit stack 3
        .limit locals 2
        new java/util/ArrayList; 
         dup 
         invokespecial java/util/ArrayList/()V 
         astore_2
         aload_2
        iload_0
        iload_1
        imul
         invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
         invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z 
         pop
         aload_2
        iload_1
        iload_0
        idiv
         invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
         invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z 
         pop
         areturn
    .end method

    .method public static _main()V
        .limit stack 3
        .limit locals 2
        ldc 1
        ldc 2
        invokestatic testex/_test(II)java/util/ArrayList;
         istore_0 
         istore_1 
        getstatic java/lang/System/out Ljava/io/PrintStream;
        iload_1
        invokevirtual java/io/PrintStream/print(I)V
        return
    .end method

    .method public static main([Ljava/lang/String;)V
        .limit stack 1
        invokestatic testex/_main()V
        return
    .end method