package mia.recommender.ch04;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.example.grouplens.GroupLensDataModel;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

final class GroupLens10MEvalIntro2 {

  private GroupLens10MEvalIntro2() {
  }

  public static void main(String[] args) throws Exception {
    DataModel model = new FileDataModel(new File("E:/Users/Administrator/github/MiA/src/main/java/mia/recommender/ch04/ratings.csv"));

    
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood =
          new NearestNUserNeighborhood(100, similarity, model);
        Recommender recommender = new GenericUserBasedRecommender(
                model, neighborhood, similarity);
        List<RecommendedItem> a = recommender.recommend(1, 10);
        for (RecommendedItem recommendation : a) {
            System.out.println(recommendation);
          }
  }

}
