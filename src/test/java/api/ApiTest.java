package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest {
    String token;
    String email = "jivando" + System.currentTimeMillis() + "@gmail.com";
    String studentId;

    @Test(priority = 1)
    public void register(){
        JSONObject dataUser = new JSONObject();
        dataUser.put("nama","jivando");
        dataUser.put("email", email);
        dataUser.put("password","Ok12345");

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(dataUser.toString())
                .post("/api/auth/register");

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Registrasi berhasil");
        Assert.assertEquals(response.jsonPath().getString("data.email"), email);
    }

    @Test(priority = 2)
    public void login(){
        JSONObject dataUser = new JSONObject();
        dataUser.put("email", email);
        dataUser.put("password","Ok12345");

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(dataUser.toString())
                .post("/api/auth/login");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "Login berhasil");
        token = response.jsonPath().getString("data.token");
        Assert.assertNotNull(token);
        System.out.print(token);
    }

    @Test(dependsOnMethods = "login")
    public void createStudent(){
        JSONObject data = new JSONObject();
        data.put("nama", "jivan");
        data.put("nis", "543216");
        data.put("kelas", "X-IPA-1");
        data.put("jurusan", "IPA");
        data.put("email", "jivan@example.com");
        data.put("telepon", "+628123456789");
        data.put("alamat", "Jl. Contoh No. 2");

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(data.toString())
                .post("/api/siswa");

        Assert.assertEquals(response.getStatusCode(), 201);
        studentId = response.jsonPath().getString("data.id");
        System.out.println("Student ID: " + studentId);
    }

    @Test(dependsOnMethods = "createStudent")
    public void getStudentId(){
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .get("/api/siswa/" + studentId);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("data.id"), studentId);
    }

    @Test(dependsOnMethods = "createStudent")
    public void patchStudent(){
        JSONObject updateData = new JSONObject();
        updateData.put("nama", "namasiswabaru");

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(updateData.toString())
                .patch("/api/siswa/" + studentId);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Siswa berhasil diupdate");
        Assert.assertEquals(response.jsonPath().getString("data.nama"), "namasiswabaru");
    }

    @Test(dependsOnMethods = "patchStudent")
    public void deleteStudent(){
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .delete("/api/siswa/" + studentId);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Siswa berhasil dihapus");
    }

    @Test(dependsOnMethods = "login")
    public void salahGetStudentId(){
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .get("/api/siswa/" + 12351235);

        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertFalse(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("error"), "Siswa tidak ditemukan");
    }

    @Test(dependsOnMethods = "login")
    public void logout() {
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .post("/api/auth/logout");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Logout berhasil");
    }
}