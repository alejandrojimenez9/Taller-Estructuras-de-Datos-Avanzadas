 static void solve() {
        int queries = i();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<String> res = new ArrayList<>();
        while (queries-- > 0) {
            String s = s();
            if (s.equals("insert")) {
                int x = i();
                pq.add(x);
                res.add(s + " " + x);
            } else if (s.equals("getMin")) {
                int x = i();
                while (pq.size() > 0 && pq.peek() < x) {
                    pq.poll();
                    res.add("removeMin");
                }
                if (pq.size() == 0 || pq.peek() > x) {
                    pq.add(x);
                    res.add("insert " + x);
                }
                res.add("getMin " + x);
            } else {
                if (pq.size() == 0) {
                    pq.add(1);
                    res.add("insert 1");
                    res.add("removeMin");
                    pq.poll();
                } else {
                    pq.poll();
                    res.add("removeMin");
                }
            }
        }
        sb.append(res.size() + "\n");
        for (String s : res) {
            sb.append(s).append("\n");
        }
    }
