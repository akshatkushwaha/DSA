
/*
An acting school planned a movie trip for its students. So, the school committee decided to book tickets for the movie. But due to certain conditions, the booking is different i.e., no two students can sit together.
The seating order of the theatre and list of groups of students are given, and the task is to book the tickets for students.

Example for seating in the theatre is as follows:
_X_X_X_X_X_X_X_X_X_X_
X_X_X_X_X_X_X_X_X_X_X
_X_X_X_X_X_X_X_X_X_X_
X_X_X_X_X_X_X_X_X_X_X
_X_X_X_X_X_X_X_X_X_X_
X_X_X_X_X_X_X_X_X_X_X

Here 'X' represents seat not available and '_' represents seat available for booking.
Each group of students and rows in the theatre has priority.
The priority of rows is from top to bottom i.e., the top row has highest priority than the lower ones.
The booking must be made based on a few conditions:
The list of students contains groups of students i.e., student list = [g1, g2, g3, g4, g5, g6...]
Here g1, g2, g3...are groups with different numbers of students. Each group represents a gang of friends.
Each group has a priority. The priority is computed as follows:
If the list has even numbed of groups say [ g1, g2, g3, g4, g5, g6], then priority is g4, g5, g6, g3, g2, g1 (highest priority to middle group in the list). So, assign 1=g4, 2=g5, 3=g6, 4=g3, 5=g2, 6=g1.
If the list has odd number of groups say [ g1, g2, g3, g4, g5, g6, g7], then priority is g4, g5, g6, g7, g3, g2, g1 (highest priority to middle group in the list). So, assign 1=g4, 2=g5, 3=g6, 4=g7, 5=g3, 6=g2, 7=g1.
Here 1 is the highest priority and 7 is the lowest priority. In general, higher the number lower the priority.
The bookings should always start from the top row of the seating arrangement given as input.
The seats should be booked from left to right.
A group always wants to sit together. So, book those seats in a single row i.e., no group can sit in two rows.
If priority 1 does not fit in row 1 but fits in row 2, then accommodate them in row 2 (succeeding row). Now, priority 2 group should be checked from row 1 if they can be accommodated.
If the group is so large that it does not fit in any of the rows, then do not book seats for them.
Input consists of seating structure, list of groups, ticket cost of a single seat in all rows except one row and total collection. Basis rows filled, seats remaining and total collection, compute the cost per seat of missing row. Then, print the seating arrangement, number of seats left after all bookings, the groups for which the tickets are not booked and cost of one ticket in the missing row. Refer the Examples section for more clarity
*/

import java.util.ArrayList;
import java.util.Scanner;

public class TicketBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRows = scanner.nextInt();

        ArrayList<String> seating = new ArrayList<>();
        for (int row = 0; row < numberOfRows; row++) {
            String rowString = scanner.next();
            seating.add(rowString);
        }

        String groupString = scanner.next();
        String[] groupStrings = groupString.split(",");
        int[] groups = new int[groupStrings.length];
        for (int group = 0; group < groupStrings.length; group++) {
            groups[group] = Integer.parseInt(groupStrings[group]);
        }

        String costPerRowString = scanner.next();
        String[] costPerRowStrings = costPerRowString.split(" ");
        int[] costPerSeatByRow = new int[costPerRowStrings.length];
        for (int row = 0; row < costPerRowStrings.length; row++) {
            if (costPerRowStrings[row].equals("?")) {
                costPerSeatByRow[row] = -1;
                continue;
            }
            costPerSeatByRow[row] = Integer.parseInt(costPerRowStrings[row]);
        }
        int totalCollection = scanner.nextInt();

        System.out.println(printCostOfPerSeatInMissingRow(seating, groups, costPerSeatByRow, totalCollection));

        scanner.close();
    }

    private static int printCostOfPerSeatInMissingRow(ArrayList<String> seating, int[] groups, int[] costPerSeatByRow, int totalCollection) {
        return 0;
    }
}
