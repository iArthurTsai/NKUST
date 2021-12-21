public class Person {
    int hp;
    int att;
    int mp;
    int attack;
    String name;
    Person(String personName, int personHp, int personAtt, int personMp){
        name = personName;
        hp = personHp;
        att = personAtt;
        mp = personMp;
    }

    void getMyCurrentStatus(){
        System.out.println("my name is : " + this.getname());
        System.out.println("my hp: " + this.gethp());
        System.out.println("my Att: " + this.getAtt());
        System.out.println("my mp: " + this.getmp());
        System.out.println("my attack: " + this.getAttack());
    }

    String getname() { return this.name; }
    int gethp() { return this.hp; }
    int getAtt() { return this.att; }
    int getmp() { return this.mp; }
    int getAttack() { return this.attack; }

    void attack(Person enemy) {
        int result = this.attack - enemy.attack;
        if(result>0){
            this.hp= this.hp- result;
        }
    }
}
