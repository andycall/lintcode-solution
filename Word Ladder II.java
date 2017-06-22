public class Solution {
    public List<String> expand(String target, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < target.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (target.charAt(i) != ch) {
                    String newWord = target.substring(0, i) + ch + target.substring(i + 1);
                    if (dict.contains(newWord)) {
                        expansion.add(newWord);
                    }
                }
            }
        }

        return expansion;
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();

        dict.add(start);
        dict.add(end);

        bfs(map, distance, start, end, dict);

        List<String> list = new ArrayList<String>();

        dfs(results, list, map, distance, start, end);

        return results;
    }

    private void dfs(List<List<String>> results, List<String> list, Map<String, List<String>> map,
                     Map<String, Integer> distance, String start, String end) {
        list.add(end);

        if (end.equals(start)) {
            Collections.reverse(list);
            results.add(new ArrayList<String>(list));
            Collections.reverse(list);
        } else {
            for (String next : map.get(end)) {
                if (distance.containsKey(next) && distance.get(end) == distance.get(next) + 1) {
                    dfs(results, list, map, distance, start, next);
                }
            }
        }
        list.remove(list.size() - 1);
    }

    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end,
                     Set<String> dict) {
        Queue<String> queue = new LinkedList<>();

        distance.put(start, 0);

        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }

        queue.add(start);

        while (!queue.isEmpty()) {
            String next = queue.poll();

            List<String> nextGroup = expand(next, dict);

            for (String str : nextGroup) {
                map.get(str).add(next);

                if (!distance.containsKey(str)) {
                    distance.put(str, distance.get(next) + 1);
                    queue.offer(str);
                }
            }
        }
    }
}