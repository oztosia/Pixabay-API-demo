package  com.oztosia.pixabay_api_demo.features.pixabayImages.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oztosia.pixabay_api_demo.features.pixabayImages.data.local.model.PixabayImageCached

@Dao
interface PixabayImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePixabayImages(vararg pixabayImage: PixabayImageCached)

    @Query("SELECT * FROM PixabayImageCached WHERE LOWER(tags) LIKE '%' || LOWER(:q) || '%'")
    suspend fun getPixabayImages(q: String): List<PixabayImageCached>
}