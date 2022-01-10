package kelimeoyunu;

public class KelimeOyunu {

    public static void main(String[] args) {
        Questions[] qList = new Questions[14];
        qList[0] = new Questions("Nağme ve melodi sözlerinin Türkçe kökenli karşılığı","ezgi");
        qList[1] = new Questions("Motorlu taşıt iskeleti","şasi");
        qList[2] = new Questions("Güç, kuvvet, derman, mecal anlamlarında bir söz","takat");
        qList[3] = new Questions("Bir şeyin üstünü kaplayan koruyucu bölüm","kabuk");
        qList[4] = new Questions("Kısa süreli, beklenmedik saldırı","baskın");
        qList[5] = new Questions("Nane esansından elde edilen, renksiz, keskin kokulu, bir tür alkol kristali","mentol");
        qList[6] = new Questions("Aynı konutu paylaşan kişilerin oluşturduğu topluluk","evhalkı");
        qList[7] = new Questions("Bir tür spor kıyafetinin 'ısınma, ısınma hareketleri’ anlamına gelen adı","eşofman");
        qList[8] = new Questions("Bazı iskambil oyunlarında oyuna kesin olarak katılması gereken kimse","mecburcu");
        qList[9] = new Questions("Optik aletlerdeki mercek sistemi","objektif");
        qList[10] = new Questions("Şamarın metaforik isimlerinden biri","beşkardeş");
        qList[11] = new Questions("Bir kurum veya kuruluşun seçip alabileceği sayı miktarı","kontenjan");
        qList[12] = new Questions("Bir çocuk oyununun, filmlerdeki hızlı takip sahneleri için de kullanılan adı","kovalamaca");
        qList[13] = new Questions("Saf ve içten duygulara sahip, kötülükten uzak, iyi niyetli","kalbitemiz");
        
        Quiz quiz = new Quiz(qList);
        
        
        
    }
    
    
    
}
