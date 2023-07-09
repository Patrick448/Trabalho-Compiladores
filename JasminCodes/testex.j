.source testex.j


.class public testex
.super java/lang/Object

<<<<<<< HEAD
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
=======
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
>>>>>>> 928fb42c166759c95c4418a78178f5e16257fe94
        return
    .end method

    .method public static main([Ljava/lang/String;)V
        .limit stack 1
        invokestatic testex/_main()V
        return
    .end method