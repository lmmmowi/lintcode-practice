package readme;

import java.io.File;

/**
 * @Author: lmmmowi
 * @Date: 2019/7/18
 * @Description:
 */
public class JavaItemFinder extends ItemFinder {

    @Override
    protected String getLanguage() {
        return "java";
    }

    @Override
    protected String[] getPackagePath() {
        return new String[]{
                "com/lmmmowi/lintcode"
        };
    }

    @Override
    protected File locateSolutionFile(File solutionDir) {
        return new File(solutionDir, "Solution.java");
    }
}
