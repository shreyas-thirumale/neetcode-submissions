class Twitter {
    Map<Integer, Set<Integer>> following;
    Map<Integer, List<Post>> posts;
    int time;
    public Twitter() {
        following = new HashMap<>();
        posts = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        posts.putIfAbsent(userId, new ArrayList<>());
        posts.get(userId).add(new Post(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> pq = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);

        if (following.containsKey(userId)) {
            for (int id : following.get(userId)) {
                if (posts.containsKey(id)) {
                    for (Post p : posts.get(id)) {
                        if (pq.size() < 10) {
                            pq.offer(p);
                        } else if (p.timestamp > pq.peek().timestamp) {
                            pq.poll();
                            pq.offer(p);
                        }
                    }
                }
            }
        }

        if (posts.containsKey(userId)) {
            for (Post p : posts.get(userId)) {
                if (pq.size() < 10) {
                    pq.offer(p);
                } else if (p.timestamp > pq.peek().timestamp) {
                    pq.poll();
                    pq.offer(p);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(0, pq.poll().postId);
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

class Post {
    int postId;
    int timestamp;

    public Post(int id, int time) {
        postId = id;
        timestamp = time;
    }
}
