package com.atguigu.oss.service.imp;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.atguigu.oss.service.OssService;
import com.atguigu.oss.utils.ConstantPropertiesValue;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImp implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile multipartFile) {

        try {
            // Endpoint以杭州为例，其它Region请按实际情况填写。
            String endpoint = ConstantPropertiesValue.END_POINT;
            // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
            String accessKeyId = ConstantPropertiesValue.ACCESS_KEY_ID;
            String accessKeySecret = ConstantPropertiesValue.ACCESS_KEY_SECRET;
            String buketName = ConstantPropertiesValue.BUCKET_NAME;

            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            //获取文件名称
            String originalFilename = multipartFile.getOriginalFilename();

            String replace = UUID.randomUUID().toString().replace("-", "");

            String fileName = replace+originalFilename;

            //按日期分类
            String datePath = new DateTime().toString("yyyy/MM/dd");

            fileName = datePath+"/"+fileName;

            //获取流
            InputStream inputStream = multipartFile.getInputStream();

            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(buketName, fileName, inputStream);

            // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // putObjectRequest.setMetadata(metadata);

            // 上传文件。
            ossClient.putObject(putObjectRequest);

            // 关闭OSSClient。
            ossClient.shutdown();
            //拼接文件路径并返回
            //https://guli-112.oss-cn-shenzhen.aliyuncs.com/wallhaven-o3dev9.jpg
            System.out.println(buketName);
            String url = "https://"+buketName+"."+endpoint+"/"+fileName;
            return url;

        }catch (Exception e){
            e.printStackTrace();
            return null;

        }

    }
}
