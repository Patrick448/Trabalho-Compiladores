.source teste6.j


.class public teste6
.super java/lang/Object

    .method public static _main()V
        .limit stack 8
        .limit locals 1
        ldc 1
        ldc 2
        iadd
        getstatic java/lang/System/out Ljava/io/PrintStream;
        invokevirtual java/io/PrintStream/print(I)V
        new I() 
        istore0;
        new java/util/Scanner
        dup
        getstatic java/lang/System/in Ljava/io/InputStream;
        invokespecial java/util/Scanner/(Ljava/io/InputStream;)V
        astore_1
        aload_1
        invokevirtual java/util/Scanner/nextInt()I
        istore_0
        int cont1 =0;
        while(cont1 < ldc 2){
            ldc "b"
            getstatic java/lang/System/out Ljava/io/PrintStream;
            invokevirtual java/io/PrintStream/print(Ljava/lang/String)V
            iconst_1
            iconst_1
            if_icmpeq #THEN0
            goto #ELSE0
            #THEN0:
                ldc "x"
                getstatic java/lang/System/out Ljava/io/PrintStream;
                invokevirtual java/io/PrintStream/print(Ljava/lang/String)V
                goto #ENDIF0
            #ELSE0:
            #ENDIF0:
            cont1++;
        }
        iconst_0
        ldc 5
        isub
        ldc 0
        if_icmplt #THEN2
        goto #ELSE2
        #THEN2:
            iconst_1
            goto #ENDIF2
        #ELSE2:
            iconst_0
        #ENDIF2:
        iconst_1
        if_icmpeq #THEN3
        goto #ELSE3
        #THEN3:
            iconst_0
            goto #ENDIF3
        #ELSE3:
            iconst_1
        #ENDIF3:
        iconst_1
        if_icmpeq #THEN4
        goto #ELSE4
        #THEN4:
            ldc "z"
            getstatic java/lang/System/out Ljava/io/PrintStream;
            invokevirtual java/io/PrintStream/print(Ljava/lang/String)V
            goto #ENDIF4
        #ELSE4:
        #ENDIF4:
        return
    .end method

    .method public static main([Ljava/lang/String;)V
        .limit stack 1
        invokestatic teste6/_main()V
        ireturn
    .end method