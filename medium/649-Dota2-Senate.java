class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()) {
            int rIdx = radiant.poll();
            int dIdx = dire.poll();

            if (rIdx < dIdx) {
                radiant.add(rIdx + n); // R bans D, and comes back next round
            } else {
                dire.add(dIdx + n); // D bans R, and comes back next round
            }
        }
        return radiant.size() == 0 ? "Dire":"Radiant";
    }
}