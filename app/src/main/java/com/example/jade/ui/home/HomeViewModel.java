package com.example.jade.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Tanti auguri amore(Si in ritardo di un bel pò lo so). \n" +
                "Volevo farti un bel regalo, qualcosa fatto da me, per te, con il cuore \n" +
                "Volevo qualcosa che stesse sempre con te, che ti ricordasse di noi, e che non possa essere perso! \n" +
                "Mi sono scervellato per pensare cosa farti, e dopo un pò ho pensato: 'Ma a cosa sono bravo io?'" +
                "E ho pensato a 3 cose, giocare, programmare e farmi le seghine(si scherza!)." +
                "E quindi eccoci qua, dopo tantissimo sangue buttato al computer il tuo regalo, fatto col cuore e le mie mani(più la tastiera e qualche dio antico) \n" +
                "Vorrei dirti tante cose, vorrei poter immortalare in questa app ogni momento, ma non è possibile. Però, è tutto salvato nelle mie memorie principali, il cuore e il cervello." +
                "Da lì non potranno più andare via. Per questo qui, ho messo qualche ricordino, giusto per farti navigare nei nostri momenti, che a loro volta poi, ne evocheranno di altri." +
                "Spero ti piaccia tanto, anche se brutta stronza hai detto che l'app che genera i motivi per il quale ti amo non ti piace come idea, ma te inzuppi lo stesso vaffanculo. Si vaffanculo!\n" +
                "" +
                "Ti amo amore, più di ogni cosa.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}