.source testex.j


.class public testex
.super java/lang/Object

    .method public static _main()V
        .limit stack 3
        .limit locals 6
        ldc 66
        istore_0
        iload_0
        ldc 65
        istore_0
        iload_0
        if_icmpgt #THEN0
        goto #ELSE0
        #THEN0:
            iconst_1
            goto #ENDIF0
        #ELSE0:
            iconst_0
        #ENDIF0:
        iconst_1
        if_icmpeq #THEN1
        goto #ELSE1
        #THEN1:
            getstatic java/lang/System/out Ljava/io/PrintStream;
            ldc 1
            istore_0
            iload_0
            invokevirtual java/io/PrintStream/print(I)V
            goto #ENDIF1
        #ELSE1:
            getstatic java/lang/System/out Ljava/io/PrintStream;
            ldc 0
            istore_0
            iload_0
            invokevirtual java/io/PrintStream/print(I)V
        #ENDIF1:
        ldc 3
        istore_0
        iload_0
        pop
        iload_0
        iload_0
        istore_1

        #WHILE2:
            iload_1
            ifne #THEN2
            goto #ENDWHILE2
            #THEN2:
                getstatic java/lang/System/out Ljava/io/PrintStream;
                ldc 0
                istore_0
                iload_0
                invokevirtual java/io/PrintStream/print(I)V
                iload_1
                iconst_1
                isub
                istore_1
                goto #WHILE2
        #ENDWHILE2:
           istore_1
        return
    .end method

    .method public static main([Ljava/lang/String;)V
        .limit stack 1
        invokestatic testex/_main()V
        return
    .end method