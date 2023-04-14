/*A class of students have a project to work on in pairs. Everyone in the class found a partner, apart from one student.
        Using the list provided (which details every student in the class represented by the number of their team), find the student with no partner.

        Note that the number of teams can represent either: only two students or the single student.
        Try to find the most efficient solution!

        INPUT
        int[]    student_list
        ^^ this contains students represented by their team number

        OUTPUT
        int    single_student_number

        CONSTRAINTS
        2 <= student_list[i] <= 100000
        3 <= i <= 10000

        EXAMPLE
        Input
        [2,4,5,4,2]
        Output
        5*/
public class Solution {

    public static int run(int[] student_list) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        int single_student_number = 0;
        for (int s : student_list){
            single_student_number ^= s;
        }
        return single_student_number;
    }
}
