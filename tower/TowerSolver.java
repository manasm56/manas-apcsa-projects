package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        // Call the missing solve method (not this one)
        if(model.height()<=0){
            return;
        }
        solve(model.height(), 0, 2, 1);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    //
    private void solve(int n, int start, int location, int temp){
        if(n==1){
            model.move(start, location);
            return;
        }
        solve(n-1, start, temp, location);
        model.move(start, location);
        solve(n-1, temp, location, start);
    }

}
