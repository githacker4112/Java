class Student {
    String name;
    int rollNo;
    String className;
    int[] marks = new int[6];
    double percentage;

    void calcPercentage() {
        int total = 0;
        for (int mark : marks) total += mark;
        percentage = total / 6.0;
    }

    static void sortStudent(Student[] arr) {
        Arrays.sort(arr, (a, b) -> Double.compare(b.percentage, a.percentage));
    }

    void display() {
        System.out.println(rollNo + " " + name + " " + percentage + "%");
    }
}
