.source testex.j


.class public testex
.super java/lang/Object

    .method public static _main()V
        .limit stack 5
        .limit locals 5
        ldc 3
        istore_0
        iload_0
        pop
        iload_0
        iload_0
        istore_1

        #WHILE1:
            iload_1
            ifne #THEN1
            goto #ENDWHILE1
            #THEN1:
                getstatic java/lang/System/out Ljava/io/PrintStream;
                ldc 0
                istore_0
                iload_0
                invokevirtual java/io/PrintStream/print(I)V
                ldc 2
                istore_0
                iload_0
                pop
                iload_0
                iload_0
                istore_1

                #WHILE0:
                    iload_1
                    ifne #THEN0
                    goto #ENDWHILE0
                    #THEN0:
                        getstatic java/lang/System/out Ljava/io/PrintStream;
                        ldc 1
                        istore_0
                        iload_0
                        invokevirtual java/io/PrintStream/print(I)V
                        iload_1
                        iconst_1
                        isub
                        istore_1
                        goto #WHILE0
                #ENDWHILE0:
                istore_1
                iload_1
                iconst_1
                isub
                istore_1
                goto #WHILE1
        #ENDWHILE1:
           istore_1
        return
    .end method

    .method public static main([Ljava/lang/String;)V
        .limit stack 1
        invokestatic testex/_main()V
        return
    .end method