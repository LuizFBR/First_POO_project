import java.util.Random;

// combinando duas interfaces para IPatient
public interface IDoctor extends IEnquirer, IResponderReceptacle, ITableProducerReceptacle {
}

public class CrazyDoctor implements IDoctor {
    private int patientN = 0;

    private ITableProducer producer;
    private IResponder responder;
  
    public void connect(ITableProducer producer) {
        this.producer = producer;
    }
    
    public void connect(IResponder responder) {
        this.responder = responder;
    }
        
    public void startInterview() {
        String instances[][] = producer.requestInstances();

        patientN = (int)(Math.random() * instances.length);
        
        
        System.out.println("Doctor guess: " + patientN);
        
        String diagnosis = interview();

        System.out.println("Disease guess: " + diagnosis);
        boolean result = responder.finalAnswer(diagnosis);
        System.out.println("Result: " + ((result) ? "I am right =)" : "I am wrong =("));
    }
    public String interview(){
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
