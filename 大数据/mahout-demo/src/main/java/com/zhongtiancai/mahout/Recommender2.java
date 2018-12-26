package com.zhongtiancai.mahout;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class Recommender2 {
	public static void main(String[] args) throws Exception {
		DataModel model = new FileDataModel(new File("G:/java-middleware-demo/大数据/mahout-demo/src/main/resources/ratings.csv"));
		// 皮尔逊相似度算法。其他的还有好多相似度算法
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

		UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);
		// 生成推荐系统
		Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		// 为用户1推荐物品1
		List<RecommendedItem> recommendations = recommender.recommend(2, 4);

		for (RecommendedItem recommendation : recommendations)

		{
			System.out.println(recommendation);
		}
	}
}
