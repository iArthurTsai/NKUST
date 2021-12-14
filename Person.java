public class Person {
    int hp;
    int att;
    int mp;
    int attack;
    String name;
    Person(String name, int personHp, int personAtt, int personMp){
        hp = personHp;
        att = personAtt;
        mp = personMp;
    }

    void getMyCurrentStatus(){
        System.out.println("my hp: " + Archer.gethp());
        System.out.println("my Att: " + Archer.getAtt());
        System.out.println("my mp: " + Archer.getmp());
        System.out.println("my attack: " + Archer.getAttack());
    }

    int gethp() { return this.hp; }
    int getAtt() { return this.att; }
    int getmp() { return this.mp; }
    int getAttack() { return this.attack; }

    void attack(Person enemy) {
        int result = this.attack - enemy.attack;
        if(result>0){
    }
}
