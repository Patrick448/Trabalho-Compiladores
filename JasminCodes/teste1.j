.source teste1.j

.class public _Object
.super java/lang/Object


.class public 4
.super java/lang/Object
    .field public _String I
    .field public 1.3 Ljava/lang/String

.class public 3
.super java/lang/Object
    .field public _Integer I

.class public teste1
.super java/lang/Object

    .method public static _myFunc(I, Ljava/lang/String)List<Object>
        .limit stack 1
        .limit locals 4
        ldc 1 
        istore2;
        ldc 3 
        istore3;
        new java/util/ArrayList 
         dup 
         invokespecial java/util/ArrayList/()V 
         astore_4
         aload_4
         iload_3
         invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
         invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z 
         pop
         aload_4
         iload_2
         invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
         invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z 
         popreturn arr;
        return
    .end method

    .method public static _main()V
        .limit stack 6
        .limit locals 5
        iconst_0
        ldc 50
        isub
        ldc 5
        iadd 
        istore0;
        new _String() 
        astore1;
        iconst_1 
        istore2;
        0
        ldc 10
        iadd 
        istore3;
        ldc "a" 
        istore4;
        ldc 6 
        istore3;
        getstatic java/lang/System/out Ljava/io/PrintStream;
         iload 4 

        invokevirtual java/io/PrintStream/print(Ljava/lang/String)V
        getstatic java/lang/System/out Ljava/io/PrintStream;
         iload ldc 200 

        invokevirtual java/io/PrintStream/print(I)V
        getstatic java/lang/System/out Ljava/io/PrintStream;
         iload 2 

        invokevirtual java/io/PrintStream/print(Z)V
        getstatic java/lang/System/out Ljava/io/PrintStream;
         aload 1 

        invokevirtual java/io/PrintStream/print(_String)V
        getstatic java/lang/System/out Ljava/io/PrintStream;
         iload 3 

        invokevirtual java/io/PrintStream/print(I)V
        return
    .end method

    .method public static main([Ljava/lang/String;)V
        .limit stack 1
        invokestatic teste1/_main()V
        ireturn
    .end method