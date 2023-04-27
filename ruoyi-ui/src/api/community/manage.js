import request from '@/utils/request'

// 查询设备设施管理列表
export function listManage(query) {
  return request({
    url: '/community/manage/list',
    method: 'get',
    params: query
  })
}

// 查询设备设施管理详细
export function getManage(deviceId) {
  return request({
    url: '/community/manage/' + deviceId,
    method: 'get'
  })
}

// 新增设备设施管理
export function addManage(data) {
  return request({
    url: '/community/manage',
    method: 'post',
    data: data
  })
}

// 修改设备设施管理
export function updateManage(data) {
  return request({
    url: '/community/manage',
    method: 'put',
    data: data
  })
}

// 删除设备设施管理
export function delManage(deviceId) {
  return request({
    url: '/community/manage/' + deviceId,
    method: 'delete'
  })
}
