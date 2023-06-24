echo
echo "--------------------TESTES CORRETOS--------------------"
echo

java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste0.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste1.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste1eMeio.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste2.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste3.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste4.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste5.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste6.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste7.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste8.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste9.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste10.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste11.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/certo/teste12.lan -v

echo
echo "--------------------TESTES ERRADOS--------------------"
echo

java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/attrAND.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/attrFALSE.cmd -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/data0.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/data1.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/data2.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/data3.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/function_call_expr.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/function_call_ret_use.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/function0.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/function1.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/if_oneCMD.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/if_teste.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/ifelse_oneCMD.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/instanciate.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/instanciate1.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/main_args.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/main_missing.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/parameters.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/parameters1.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/parameters2.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/return.lan -v
java -cp .:antlr-4.8-complete.jar Intepretador testes/semantica/errado/teste8.lan -v

