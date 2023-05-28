package modulo2.clasesYObjetos.vistaPublica.ContratoLimpiezav1;

public class Interval {
    private double min;
    private double max;

    public Interval(double min, double max){
        this.min = min;
        this.max = max;
    }

    public Interval(double max){
        this(0,max);
    }

    public Interval(){
        this(0);
    }

    public Interval clone(){
        return new Interval(this);
    }

    private Interval(Interval interval) {
        this(interval.min, interval.max);
    }

    public double length(){
        return this.max - this.min;
    }

    public double middlePoint(){
        return (this.min+this.max)/2;
    }

    public void scale(double scale){
        double newMiddlePoint = this.middlePoint();
        double newLength = this.length()*scale;
        this.min = (newLength - newMiddlePoint) /2;
        this.max =(newLength+newMiddlePoint)/2;
    }

    public Interval scaled(double scale){
        Interval interval = this.clone();
        interval.scale(scale);
        return interval;
    }

    public Interval oposite(){
    return new Interval(-this.min,-this.max);
    }

    public boolean includes(double point){
        return this.min <= point && this.max >= point;
    }
    public boolean includes(Interval point){
        return this.includes(this.min) && this.includes(this.max);
    }

    public boolean isIntersected(Interval interseted){
        return  this.includes(this.min) || this.includes(this.max) || interseted.includes(this);
    }

    public Interval intersection(Interval interval){
        Interval intersection = this.clone();
        if (interval.min > this.min ) {
            intersection.min   = interval.min;
        }
        if (interval.max > this.max) {
            intersection.max = interval.max;
        }
        return intersection;
    }


    public Interval union(Interval interval){
        Interval union = this.clone();
        if (interval.min < this.min) {
            union.min = interval.min;
        }
        if (interval.max > this.max) {
            union.max = interval.max;
        }
        return union;
    }

    public Interval shiftef(float shiftef){
        return new Interval(this.min+shiftef,this.max+shiftef);
    }

    public void shift(double cantidad) {
        this.min += cantidad;
        this.max += cantidad;
    }

    public Interval[] split(int times){
         Interval[] intervals = new Interval[times];
         final double length = this.length()/times;
         double origin = this.min;
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = new Interval(origin,origin+length);
            origin+=length;
        }
        return  intervals;
    }

    @Override
    public String toString() {
        return "[ "+this.min + "; " + this.max+" ]";
    }

    public void read(){
        boolean error;
        do {
            this.min = Console.getInstance().readDouble("Dame el mínimo del intervalo: ");
            this.max = Console.getInstance().readDouble("Dame el máximo del intervalo: ");
            error = this.min <= this.max;
            if (error) {
                Console.getInstance().writeln("El minimo no puede ser mayor que el maximo");
            }
        } while (error);
    }

    public void writeln() {
        Console.getInstance().writeln(this.toString());
    }



}

