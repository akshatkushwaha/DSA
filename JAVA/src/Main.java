import java.util.*;

class User {
    private String name;
    private Set<String> followers;
    private Set<String> followees;

    public User(String name) {
        this.name = name;
        this.followers = new HashSet<>();
        this.followees = new HashSet<>();
    }

    public void addFollower(String follower) {
        this.followers.add(follower);
    }

    public void addFollowee(String followee) {
        this.followees.add(followee);
    }

    public Set<String> getFollowers() {
        return followers;
    }

    public Set<String> getFollowees() {
        return followees;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    private static final int USER_NAME_INDEX = 0;
    private static final int POST_CONTENT_INDEX = 1;
    private static final int TIMESTAMP_INDEX = 2;
    private static final int FOLLOWER_INDEX = 3;
    private static final int FOLLOWEE_INDEX = 4;

    public static void main(String[] args) {
        List<String> stream = new ArrayList<>();

        // Name || Post #hashtags||Timestamp||Follower||Followee
        stream.add("Alice||Hello #Greetings||1635739200||Bob||Zara");
        stream.add("Bob||Morning #Greetings||1635739500||Alice||Zara");
        stream.add("Zara||Hi #Chill||163539800||Alice||Eve");
        stream.add("Zara||Hi #Chill||163539800||Bob||Frank");
        stream.add("Zara||Hey #Greetings||163539900||Eve||Frank");

        String source = "Alice";
        String target = "Bob";

        List<User> users = buildUsersFromStream(stream);
        System.out.println(maxFollowerCount(users));
        System.out.println(minimumDistance(users, source, target));
    }

    private static List<User> buildUsersFromStream(List<String> stream) {
        Map<String, User> users = new HashMap<>();

        for (String post : stream) {
            String[] postDetails = post.split("\\|\\|");
            String name = postDetails[USER_NAME_INDEX];
            String follower = postDetails[FOLLOWER_INDEX];
            String followee = postDetails[FOLLOWEE_INDEX];

            users.computeIfAbsent(name, User::new);
            users.computeIfAbsent(follower, User::new);
            users.computeIfAbsent(followee, User::new);

            users.get(name).addFollower(follower);
            users.get(follower).addFollowee(name);
            users.get(name).addFollowee(followee);
            users.get(followee).addFollower(name);
        }

        return new ArrayList<>(users.values());
    }

    private static String maxFollowerCount(List<User> users) {
        int maxFollowerCount = 0;
        String maxFollowerName = "";

        for (User user : users) {
            int followerCount = user.getFollowers().size();
            if (followerCount > maxFollowerCount) {
                maxFollowerCount = followerCount;
                maxFollowerName = user.getName();
            }
        }

        return maxFollowerName;
    }

    private static int minimumDistance(List<User> users, String source, String target) {
        Map<String, Integer> distance = new HashMap<>();
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        distance.put(source, 0);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.equals(target)) {
                return distance.get(curr);
            }

            for (String followee : findUserByName(users, curr).getFollowees()) {
                if (!visited.contains(followee)) {
                    queue.add(followee);
                    visited.add(followee);
                    distance.put(followee, distance.get(curr) + 1);
                }
            }

            for (String follower : findUserByName(users, curr).getFollowers()) {
                if (!visited.contains(follower)) {
                    queue.add(follower);
                    visited.add(follower);
                    distance.put(follower, distance.get(curr) + 1);
                }
            }
        }

        return -1;
    }

    private static User findUserByName(List<User> users, String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }
}
