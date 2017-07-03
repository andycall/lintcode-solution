/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
       // Write your code here
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i = 0; i < results.length; i ++) {
            Record record = results[i];

            if (!map.containsKey(record.id)) {
                map.put(record.id, new PriorityQueue<Integer>());
            }

            PriorityQueue<Integer> queue = map.get(record.id);

            if (queue.size() < 5) {
                queue.offer(record.score);
            }
            else {
                if (record.score > queue.peek()) {
                    queue.poll();
                    queue.offer(record.score);
                }
            }
        }

        Map<Integer, Double> ret = new HashMap<>();
        
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> queue = entry.getValue();

            double avg = 0.0;
            for(int i = 0; i < 5; i ++ ) {
                avg += queue.poll();
            }
            avg = avg / 5.0;
            ret.put(id, avg);
        }

        return ret;
    }
}