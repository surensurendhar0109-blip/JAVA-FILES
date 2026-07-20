 class check if straight line {
    public boolean checkStraightLine(int[][] coordinates) {
        // We need at least 2 points to define a line.
        // The problem constraint says coordinates.length >= 2, so this is always true.
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        
        int dx = x1 - x0;
        int dy = y1 - y0;
        
        // Check collinearity for all subsequent points
        for (int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0];
            int yi = coordinates[i][1];
            
            // Using cross-multiplication: dy / dx == (yi - y0) / (xi - x0)
            if (dy * (xi - x0) != (yi - y0) * dx) {
                return false;
            }
        }
        
        return true;
    }
}