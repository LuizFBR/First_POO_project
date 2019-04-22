package class;

public class QuestionTreeComponent implements IQuestionTree{
        
        public String interview(IResponder responder){
            String attributes[] = producer.requestAttributes();

            if ( responder.ask(attributes[4]).equals("yes")) return "bite_deficit";
            else if ( responder.ask(attributes[0]).equals("yes")) return "bacterial_infection";
            if ( responder.ask(attributes[1]).equals("yes")) {
                if ( responder.ask(attributes[6]).equals("yes")) return "bite_deficit";
                else return "bacterial_infection";
            }
            else if ( responder.ask(attributes[3]).equals("yes")){
                if ( responder.ask(attributes[6]).equals("yes") || responder.ask(attributes[2]).equals("yes")) return "viral_infection";
                else return "viral_infection and fight";
            }
            else if ( responder.ask(attributes[3]).equals("no")){
                if ( responder.ask(attributes[2]).equals("yes")) return "fights";
                else if ( responder.ask(attributes[5]).equals("yes")) return "nothing";
            }
        
        return "unknown";
    }
}
