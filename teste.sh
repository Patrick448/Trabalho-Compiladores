echo
echo "--------------------TESTES CORRETOS--------------------"
echo

java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste0.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste1.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste1eMeio.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste2.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste3.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste4.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste5.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste6.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste7.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste8.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste9.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste10.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste11.lan -s -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/certo/teste12.lan -s -v

echo
echo "--------------------TESTES ERRADOS--------------------"
echo

java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/attrAND.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/attrFALSE.cmd -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/data0.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/data1.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/data2.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/data3.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/function_call_expr.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/function_call_ret_use.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/function0.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/function1.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/if_oneCMD.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/if_teste.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/ifelse_oneCMD.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/instanciate.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/instanciate1.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/main_args.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/main_missing.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/parameters.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/parameters1.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/parameters2.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/return.lan -i -v
java -cp .:antlr-4.8-complete.jar LangCompiler testes/semantica/errado/teste8.lan -i -v

