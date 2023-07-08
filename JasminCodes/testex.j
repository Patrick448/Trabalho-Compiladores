.source testex.j
.class public testex
.super java/lang/Object


    .method public static _myFunction()V
        .limit stack 32
        .limit locals 32
        getstatic java/lang/System/out Ljava/io/PrintStream;
        ldc 3654
        invokevirtual java/io/PrintStream/print(I)V
        return
    .end method

    .method public static _main()V
        .limit stack 32
        .limit locals 32
        getstatic java/lang/System/out Ljava/io/PrintStream;
        ldc 22222
        invokevirtual java/io/PrintStream/print(I)V
        return
    .end method

    .method public static main([Ljava/lang/String;)V
        .limit stack 1
        invokestatic testex/_main()V
        return
    .end method