package readme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: lmmmowi
 * @Date: 2019/7/18
 * @Description:
 */
public abstract class ItemFinder {

    private static final Pattern pattern = Pattern.compile(".* (\\d+)\\.\\s*(.*)\\[(.*)\\]");

    public List<SolutionItem> findItems(File projectDir) {
        File srcDir = new File(projectDir, this.getSrcDirPath());
        List<File> targetDirs = Arrays.stream(this.getPackagePath())
                .map(path -> new File(srcDir, path))
                .map(f -> f.listFiles(File::isDirectory))
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return targetDirs.stream()
                .map(this::locateSolutionFile)
                .filter(File::exists)
                .map(file -> {
                    SolutionItem item = parseSolutionItem(file);
                    if (item != null) {
                        item.language = this.getLanguage();
                        item.solutionUrl = this.getGithubPageUrl(projectDir, file);
                    }
                    return item;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    protected SolutionItem parseSolutionItem(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    ProblemType problemType = line.contains("剑指 Offer") ? ProblemType.OFFER : ProblemType.NORMAL;

                    SolutionItem item = new SolutionItem();
                    item.num = Integer.valueOf(matcher.group(1));
                    item.name = matcher.group(2);
                    item.url = matcher.group(3);
                    item.problemType = problemType;
                    return item;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected String getGithubPageUrl(File projectDir, File solutionFile) {
        String githubBase = "https://github.com/lmmmowi/lintcode-practice/blob/master/";
        String relativeFilePath = solutionFile.getAbsolutePath().substring(projectDir.getAbsolutePath().length());
        relativeFilePath = relativeFilePath.replace("\\", "/");
        if (relativeFilePath.startsWith("/")) {
            relativeFilePath = relativeFilePath.substring(1);
        }
        return githubBase + relativeFilePath;
    }

    protected String getSrcDirPath() {
        return String.format("src/main/%s/", getLanguage());
    }

    protected abstract String[] getPackagePath();

    protected abstract File locateSolutionFile(File solutionDir);

    protected abstract String getLanguage();

}
