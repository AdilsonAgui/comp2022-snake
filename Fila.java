public class Fila {
    private Snake snake;
    
    public Fila(){
        this.snake = null;
   }
    public void inserir (Snake node){
        if(isEmpty()){
            this.snake = node;
            snake.setAnterior(null);
        }else{
            node.setAnterior(snake);
            snake = node;
        }
   }
   public void remover (){
       Snake aux = snake;
       if(aux.getAnterior() == null){
           snake = null;
        }else{
       while(aux.getAnterior() != null){
                aux = aux.getAnterior();
                aux.setAnterior(null);
                 break;
       }
          
        } 
   } 
   private boolean isEmpty (){
        if(this.snake == null){
            return true;
        }
        return false;
   }
}
